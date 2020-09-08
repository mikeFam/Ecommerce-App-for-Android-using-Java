package com.example.myapplication;

import com.example.myapplication.models.Shoe;

import java.util.ArrayList;

public class DataProvider {
    static String[] names = {"KD12","KD13","Lebron 16", "Lebron 17", "Kobe A.D.", "Adapt BB", "Kobe A.D. NXT", "Kobe 1 Protro", "Kyrie 5", "Kyrie 6",
            "Dame 5", "Dame 6", "Harden Vol.3", "Harden Vol.4", "N3XT L3V3L", "D Rose 9", "D Rose 10", "D.O.N Issue #1", "Crazy BYW X", "Marquee Boost",
            "Why Not? Zer0.2","Why Not? Zer0.3", "XXXIV", "XXXIII", "Jumpman Diamond", "CP XII", "CP XI", "Melo M13", "XXXI", "XXXII",
            "ZO2 Prime Remix", "ZO2.19",
            "OM1NS",
            "Curry 6", "Curry 7"};
    static int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};

    static  String[] brands = {"Nike", "Nike", "Nike", "Nike", "Nike", "Nike", "Nike", "Nike", "Nike", "Nike",
            "Adidas", "Adidas", "Adidas", "Adidas", "Adidas", "Adidas", "Adidas", "Adidas", "Adidas", "Adidas",
            "Jordan", "Jordan", "Jordan", "Jordan", "Jordan", "Jordan", "Jordan", "Jordan", "Jordan", "Jordan",
            "Big Baller Brand", "Big Baller Brand",
            "New Balance",
            "Under Armour", "Under Armour"};

    static  double[] prices = {190, 250, 200, 299, 160, 350, 200, 175, 130, 150,
            155, 110, 140, 130, 180, 140, 140, 100, 180, 130,
            120, 130, 180, 175, 120, 100, 115, 135, 185, 185,
            500, 700,
            140,
            130, 140};

    static int[] images = {R.drawable.b001, R.drawable.b101, R.drawable.b102, //KD12
            R.drawable.b002, R.drawable.b202, R.drawable.b203, //KD13
            R.drawable.b003, R.drawable.b302, R.drawable.b303, //Lebron 16
            R.drawable.b004, R.drawable.b402, R.drawable.b403, //Lebron 17
            R.drawable.n005, R.drawable.n502, R.drawable.n503, //Kobe A.D.
            R.drawable.n006, R.drawable.n602, R.drawable.n603, //Adapt BB
            R.drawable.n007, R.drawable.n702, R.drawable.n703, //Kobe A.D. NXT
            R.drawable.n008, R.drawable.n802, R.drawable.n803, //Kobe 1 Protro
            R.drawable.n009, R.drawable.n902, R.drawable.n903, //Kyrie 5
            R.drawable.n010, R.drawable.n102, R.drawable.n103, //Kyrie 6

            R.drawable.b005, R.drawable.b502, R.drawable.b503, //Dame 5
            R.drawable.b012, R.drawable.a202, R.drawable.a203, //Dame 6
            R.drawable.b007, R.drawable.a302, R.drawable.a303, //Harden vol 3
            R.drawable.b008, R.drawable.a402, R.drawable.a403, //Harden vol 4
            R.drawable.a005, R.drawable.a502, R.drawable.a503, //N3XT L3V3l
            R.drawable.a006, R.drawable.a602, R.drawable.a603, //D Rose 9
            R.drawable.a007, R.drawable.a702, R.drawable.a703, //D Rose 10
            R.drawable.a008, R.drawable.a802, R.drawable.a803, //D.O.N Issue #1
            R.drawable.a009, R.drawable.a902, R.drawable.a903, //Crazy BYW X
            R.drawable.a010, R.drawable.a102, R.drawable.a103, //Marquee Boost

            R.drawable.b009, R.drawable.j101, R.drawable.j103, //Why Not 2
            R.drawable.b010, R.drawable.j202, R.drawable.j203, //WHy Not 3
            R.drawable.b011, R.drawable.b012, R.drawable.j303, //XXXIV
            R.drawable.j004, R.drawable.j402, R.drawable.j403, //XXXIII
            R.drawable.j005, R.drawable.j502, R.drawable.j503, //Jumpman Diamond
            R.drawable.j006, R.drawable.j602, R.drawable.j603, //CP XII
            R.drawable.j007, R.drawable.j702, R.drawable.j703, //CP XI
            R.drawable.j008, R.drawable.j802, R.drawable.j803, //Melo M13
            R.drawable.j009, R.drawable.j901, R.drawable.j903, //XXXI
            R.drawable.j010, R.drawable.j102, R.drawable.j104, //XXXII

            R.drawable.z001, R.drawable.z002, R.drawable.z003, //Prime Remix
            R.drawable.z004, R.drawable.z005, R.drawable.z006, //19

            R.drawable.n001, R.drawable.n002, R.drawable.n003, //OMN1s

            R.drawable.c001, R.drawable.c002, R.drawable.c003, //Curry 6
            R.drawable.c004, R.drawable.c005, R.drawable.c006  //Curry 7
    };



    static String[] descriptions = {
            "Top Review: The shoes is a great performer with outstanding cushioning",
            "Top Review: Similar Kobe AD Mid from 2017",
            "Top Review: The shoes is an outstanding performance fir explosive and powerful wing player",
            "Top Review: The shoes is great for heavier player",
            "Top Review: Very solid performance shoes recommend for quicker guard",
            "Top Review: Really good performer with latest technology",
            "Top Review: Expensive shoe but good overall for quick guard",
            "Top Review: Old-school basketball shoe but not for minimalist type person",
            "Top Review: Supportive shoe works best for guard",
            "Top Review: Improvement from all previous shoes - best Kyrie shoe",
            "Top Review: Very affordable for a great performer",
            "Top Review: Good performer with flaws in traction and durability",
            "Top Review: Improvement in all areas and one of the best shoe in 2018",
            "Top Review: A very supportive, fast and low-profile basketball shoe",
            "Top Review: Great performer that will make you stand out on the court",
            "Top Review: This shoe is very wide and loose fit that does not provide the lockdown and containment need for crossover",
            "Top Review: This is a little underwhelming to compare with other shoes in same price range",
            "Top Review: Provide a lot of support and stability",
            "Top Review: The review is mixed: best performance basketball shoes vs flawed and overpriced",
            "Top Review: The shoe with flashy design and no glaring weaknesses",
            "Top Review: Work well with explosive player that looking for a nicely-balanced sneaker",
            "Top Review: Great performer and best Air Jordan since the AJ29",
            "Top Review: Very divisive shoe however very expensive ",
            "Top Review: Sneaker performs above average in all categories and the priced very fairly",
            "Top Review: Huge sleeper: great shoe at an even better price",
            "Top Review: All-around performer should work well for all positions",
            "Top Review: Stationary post up players might like the comfortable cushioning",
            "Top Review: Could have been a great shoe but the traction is really killing",
            "Top Review: Very good all-around performer that will work for all types of basketball players",
            "Top Review: Provide a lot of support and stability",
            "Top Review: Shoes is too expensive for below average performance",
            "Top Review: N/A - No review has been done on the item",
            "Top Review: Highly recommended for players of all positions that is looking for a well balanced performer",
            "Top Review: The shoe brought a lot of fun while testing plus rank it as one of the best Curry shoes",
            "Top Review: Solid performer that works best for players looking for a responsive low-top with great traction"
    };

    public static ArrayList<Shoe> generateData() {
        ArrayList<Shoe> shoes = new ArrayList<Shoe>();

        for (int i = 0; i < ids.length; i++){
            int[] photos;
            int image = 0;
            photos = new int[3];
            int id = ids[i];
            String brand = brands[i];
            String name = names[i];
            String description = descriptions[i];

            for (int y = 0; y < 3; y++){
                photos[y] = images[i*3 + y];
                image = photos[0];
            }
            double price = prices[i];
            Shoe aShoe = new Shoe(id, name, brand, price, image, photos, description);
            shoes.add(aShoe);
        }
        return shoes;
    }
}


