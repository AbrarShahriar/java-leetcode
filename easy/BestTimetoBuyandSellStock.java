import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] t1 = { 7, 1, 1, 13, 6, 0, 9, 2, 8, 2 };
        int[] t2 = { 7, 6, 4, 3, 1 };
        int[] t3 = { 1, 2 };
        int[] t4 = { 2, 1 };
        int[] t5 = { 1, 2, 4, 9, 1 };
        int[] t6 = getLotsOfData();
        int[] t7 = { 897, 265, 201, 86, 56, 657, 273, 25, 843, 625, 641, 332, 509, 463, 496, 97, 779, 241,
                970, 665,
                87, 765, 276, 442, 25, 311, 10, 765, 224, 465, 296, 415, 968, 40, 494, 151, 493, 159, 274, 444, 10, 792,
                104, 200, 694, 193, 616, 126, 754, 3, 489, 415, 863, 589, 646, 264, 88, 733, 132, 922, 794, 149, 496,
                135, 727, 355, 890, 102, 3, 668, 517, 852, 488, 445, 980, 964, 933, 754, 815, 496, 550, 2, 33, 191, 516,
                455, 436, 41, 618, 596, 334, 10, 708, 348, 511, 752, 767, 129, 470, 698, 647, 604, 104, 811, 574, 52,
                750, 319, 97, 45, 391, 42, 822, 712, 92, 664, 318, 702, 5, 303, 778, 799, 638, 430, 66, 944, 78, 40,
                632, 919, 828, 851, 589, 75, 328, 774, 991, 305, 126, 996, 505, 463, 428, 972, 781, 697, 244, 98, 148,
                670, 30, 328, 457, 673, 766, 69, 461, 44, 804, 986, 133, 169, 786, 950, 745, 63, 362, 857, 411, 12, 680,
                9, 586, 827, 932, 54, 538, 509, 120, 287, 534, 866, 926, 351, 634, 842, 188, 57, 443, 296, 134, 254,
                447, 350, 558, 418, 917, 492, 683, 702, 504, 964, 319, 717, 178, 400, 226, 66, 969, 183, 703, 231, 38,
                684, 197, 245, 600, 97, 126, 536, 612, 54, 414, 827, 598, 4, 368, 412, 248, 293, 270, 937, 847, 265,
                801, 278, 64, 600, 254, 54, 791, 608, 782, 532, 719, 76, 224, 981, 695, 727, 987, 567, 230, 149, 807,
                721, 0, 301, 881, 713, 514, 196, 672, 444, 12, 559, 927, 791, 228, 215, 552, 50, 409, 660, 356, 402, 45,
                989, 859, 224, 90, 219, 371, 241, 568, 177, 486, 920, 28, 549, 538, 537, 232, 168, 792, 367, 415, 517,
                817, 471, 800, 278, 848, 173, 441, 420, 789, 456, 338, 681, 490, 610, 171, 691, 423, 510, 952, 152, 120,
                872, 603, 922, 51, 419, 391, 555, 155, 945, 231, 411, 406, 233, 591, 704, 217, 721, 305, 168, 914,
                219 };

        long startTime = System.nanoTime();

        System.out.println(maxProfit(t1));
        System.out.println(maxProfit(t2));
        System.out.println(maxProfit(t3));
        System.out.println(maxProfit(t4));
        System.out.println(maxProfit(t5));
        System.out.println(maxProfit(t6));
        System.out.println(maxProfit(t7));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + duration + " ms");
    }

    static int maxProfit(int[] prices) {
        int maxProf = 0, minPrice = prices[0];

        System.out.println("Start minPrice " + minPrice);
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > maxProf) {
                maxProf = prices[i] - minPrice;
            }
        }

        return maxProf;
    }

    // For larger dataset
    static int[] getLotsOfData() {
        List<Integer> list = new ArrayList<>();

        // Read the array elements from a file
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            String line = br.readLine();
            String[] elements = line.split(",");
            for (String element : elements) {
                list.add(Integer.parseInt(element.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert list to array
        int[] nums = list.stream().mapToInt(i -> i).toArray();

        return nums;
    }
}