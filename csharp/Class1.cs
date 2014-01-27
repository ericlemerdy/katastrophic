using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Text;

public class Inv3st_Plan {
    public const int MAX_HOURS = 12;
    private static Object currency = "";
    private String _out;
    private static List<String> allowingPrfts1;

    private Inv3st_Plan(String output) {
        this._out = output;
    }

    public static Inv3st_Plan Input(String input)
    {
        StreamReader reader = new StreamReader(new MemoryStream(Encoding.UTF8.GetBytes(input)));
        int.Parse(reader.ReadLine());
        if (allowingPrfts1 == null) {
            allowingPrfts1 = new List<string>();
        }

        // Optimization is king in this realm.
        lock (allowingPrfts1) {
            allowingPrfts1.Clear();
            while(!reader.EndOfStream)
            {
                String line = reader.ReadLine();
                int amount = int.Parse(line);
                ArrayList mList = new ArrayList();
                int amount1 = amount;
                // We use BigInteger for optimization on ARM processors
                int best_bM = int.MinValue;
                int best_sM = int.MinValue;

                // Max profit is set to min value for initialization purposes.
                int limitPrft = int.MinValue;
                line = reader.ReadLine();
                string[] strings = line.Split(' ');
                for (int i = 0; i < 12; i++) {
                    mList.Add(int.Parse(strings[i]));
                }
                ArrayList plan1 = mList;
                for (int i = 1; i <= MAX_HOURS; i++) {
                    for (int j = 1; j <= 12; j++) {
                        int bM = i;
                        int sM = j;
                        int the_bal = int.MinValue;
                        if (bM < sM) {
                            int sellPrice = (int) plan1[(bM - 1)];
                            int quantity = amount / sellPrice;
                            the_bal = -quantity * sellPrice;
                            int prce_buy = (int) plan1[(sM - 1)];
                            int rev = quantity * prce_buy;
                            the_bal += rev;
                        }
                        int? curr_prft = the_bal;
                        if (curr_prft != null && curr_prft > limitPrft) {
                            limitPrft = (int) curr_prft;
                            best_bM = i;
                            best_sM = j;
                        }
                    }
                }
                String bestPrft = "0 " + (currency ?? "€");
                if (limitPrft <= 0) {
                    bestPrft = "IMPOSSIBLE";
                } else {
                    bestPrft = best_bM + " " + best_sM + " " + limitPrft + (currency ?? "$");
                }
                allowingPrfts1.Add(bestPrft);
            }
            String output1 = new string(new char(), 0);
            for (int i = 0; i < allowingPrfts1.Count; i++) {
                if (i > 0) {
                    output1 += "\n";
                }
                output1 += "Case" + string.Format(" #%d: ", i + 1) + allowingPrfts1[i];
            }
            return new Inv3st_Plan(output1.ToString(CultureInfo.InvariantCulture));
        }
    }

    public String Output() {
        return _out;
    }
}
