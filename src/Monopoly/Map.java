package Monopoly;

import java.util.ArrayList;

public class Map {
        //différents groupes
        final int BROWN = 1;
        final int LIGHT_BLUE = 2;
        final int PURPLE = 3;
        final int ORANGE = 4;
        final int RED = 5;
        final int YELLOW = 6;
        final int GREEN = 7;
        final int BLUE = 8;
        final int PUBLIC = 9;
        final int GARE = 10;
        final int NON_ACHETABLE = 11;

        public ArrayList<Property> map = new ArrayList<Property>();
        public ArrayList<Property> plat = new ArrayList<Property>();

        Map() {
            for(int y = 0; y <= 10; y++) {
                for (int x = 0; x <= 10; x++) {
                    //top row
                    if (y == 0) {
                        if (x == 0) {
                            map.add(new Property()
                                    .Available(false).Name("Parc gratuit").Value(0).Group(NON_ACHETABLE));
                        } else if (x == 1) {
                            map.add(new Property()
                                    .Available(true).Name("Avenu matignion").Value(220).Group(RED));
                        } else if (x == 2) {
                            map.add(new Property()
                                    .Available(false).Name("Chance").Value(0).Group(NON_ACHETABLE));
                        } else if (x == 3) {
                            map.add(new Property()
                                    .Available(true).Name("Boulevard malherbe").Value(220).Group(RED));
                        } else if (x == 4) {
                            map.add(new Property()
                                    .Available(true).Name("Avenue Henry Martin").Value(240).Group(RED));
                        } else if (x == 5) {
                            map.add(new Property()
                                    .Available(true).Name("Gare du nord").Value(200).Group(GARE));
                        } else if (x == 6) {
                            map.add(new Property()
                                    .Available(true).Name("Faubourg st-honoré").Value(260).Group(YELLOW));
                        } else if (x == 7) {
                            map.add(new Property()
                                    .Available(true).Name("Place de la bourse").Value(260).Group(YELLOW));
                        } else if (x == 8) {
                            map.add(new Property()
                                    .Available(true).Name("Compagnie des eaux").Value(150).Group(PUBLIC));
                        } else if (x == 9) {
                            map.add(new Property()
                                    .Available(true).Name("Place de la bourse").Value(280).Group(YELLOW));
                        } else if (x == 10) {
                            map.add(new Property()
                                    .Available(false).Name("Prison").Value(0).Group(NON_ACHETABLE));
                        }
                    } // end top row
                    //bottom row
                    else if (y == 10) {
                        if (x == 0) {
                            map.add(new Property()
                                    .Available(false).Name("Prison").Value(0).Group(NON_ACHETABLE));
                        } else if (x == 1) {
                            map.add(new Property()
                                    .Available(true).Name("Avenu de la republique").Value(120).Group(LIGHT_BLUE));
                        } else if (x == 2) {
                            map.add(new Property()
                                    .Available(true).Name("Rue de courcelle").Value(100).Group(LIGHT_BLUE));
                        } else if (x == 3) {
                            map.add(new Property()
                                    .Available(false).Name("Chance").Value(0).Group(NON_ACHETABLE));
                        } else if (x == 4) {
                            map.add(new Property()
                                    .Available(true).Name("Avenu de Vaugirard").Value(100).Group(LIGHT_BLUE));
                        } else if (x == 5) {
                            map.add(new Property()
                                    .Available(true).Name("Gare de montparnasse").Value(200).Group(GARE));
                        } else if (x == 6) {
                            map.add(new Property()
                                    .Available(false).Name("Impot sur le revenue").Value(200).Group(NON_ACHETABLE));
                        } else if (x == 7) {
                            map.add(new Property()
                                    .Available(true).Name("Rue lecourbe").Value(60).Group(BROWN));
                        } else if (x == 8) {
                            map.add(new Property()
                                    .Available(false).Name("Caisse de communauté").Value(0).Group(NON_ACHETABLE));
                        } else if (x == 9) {
                            map.add(new Property()
                                    .Available(true).Name("Boulevard de belville").Value(60).Group(BROWN));
                        } else if (x == 10) {
                            map.add(new Property()
                                    .Available(false).Name("Départ").Value(200).Group(NON_ACHETABLE));
                        }
                    } // end bottom row
                    // left row
                    else if (x == 0) {
                        if (y == 0) {
                            map.add(new Property()
                                    .Available(false).Name("Prison").Value(0).Group(NON_ACHETABLE));
                        } else if (y == 1) {
                            map.add(new Property()
                                    .Available(true).Name("Place pigalle").Value(200).Group(ORANGE));
                        } else if (y == 2) {
                            map.add(new Property()
                                    .Available(true).Name("Boulevard st-Michel").Value(180).Group(ORANGE));
                        } else if (y == 3) {
                            map.add(new Property()
                                    .Available(false).Name("Caisse de communauté").Value(0).Group(NON_ACHETABLE));
                        } else if (y == 4) {
                            map.add(new Property()
                                    .Available(true).Name("Avenu Mozart").Value(180).Group(ORANGE));
                        } else if (y == 5) {
                            map.add(new Property()
                                    .Available(true).Name("Gare de lyon").Value(200).Group(GARE));
                        } else if (y == 6) {
                            map.add(new Property()
                                    .Available(true).Name("Rue de Paradis").Value(160).Group(PURPLE));
                        } else if (y == 7) {
                            map.add(new Property()
                                    .Available(true).Name("Avenue de Neuilly").Value(140).Group(PURPLE));
                        } else if (y == 8) {
                            map.add(new Property()
                                    .Available(true).Name("Compagnie de l'electricité").Value(150).Group(PUBLIC));
                        } else if (y == 9) {
                            map.add(new Property()
                                    .Available(true).Name("Boulevard de la Villette").Value(140).Group(PURPLE));
                        }
                    } // end left row
                    // right row
                    else if (x == 10) {
                        if (y == 1) {
                            map.add(new Property()
                                    .Available(true).Name("Avenue de breteuil").Value(300).Group(GREEN));
                        } else if (y == 2) {
                            map.add(new Property()
                                    .Available(true).Name("Avenue Foch").Value(300).Group(GREEN));
                        } else if (y == 3) {
                            map.add(new Property()
                                    .Available(false).Name("Caisse de Communauté").Value(0).Group(NON_ACHETABLE));
                        } else if (y == 4) {
                            map.add(new Property()
                                    .Available(true).Name("Boulevard de Capucine").Value(320).Group(GREEN));
                        } else if (y == 5) {
                            map.add(new Property()
                                    .Available(true).Name("Gare st-Lazard").Value(200).Group(GARE));
                        } else if (y == 6) {
                            map.add(new Property()
                                    .Available(false).Name("Chance").Value(0).Group(NON_ACHETABLE));
                        } else if (y == 7) {
                            map.add(new Property()
                                    .Available(true).Name("Avenue des champs élysés").Value(350).Group(BLUE));
                        } else if (y == 8) {
                            map.add(new Property()
                                    .Available(false).Name("Taxe de luxe").Value(100).Group(NON_ACHETABLE));
                        } else if (y == 9) {
                            map.add(new Property()
                                    .Available(true).Name("Rue de la paix").Value(400).Group(BLUE));
                        }
                    }//end right row
                }
            }
            plat.add(map.get(39));
            plat.add(map.get(38));
            plat.add(map.get(37));
            plat.add(map.get(36));
            plat.add(map.get(35));
            plat.add(map.get(34));
            plat.add(map.get(33));
            plat.add(map.get(32));
            plat.add(map.get(31));
            plat.add(map.get(30));
            plat.add(map.get(29));
            plat.add(map.get(27));
            plat.add(map.get(25));
            plat.add(map.get(23));
            plat.add(map.get(21));
            plat.add(map.get(19));
            plat.add(map.get(17));
            plat.add(map.get(15));
            plat.add(map.get(13));
            plat.add(map.get(11));
            plat.add(map.get(0));
            plat.add(map.get(1));
            plat.add(map.get(2));
            plat.add(map.get(3));
            plat.add(map.get(4));
            plat.add(map.get(5));
            plat.add(map.get(6));
            plat.add(map.get(7));
            plat.add(map.get(8));
            plat.add(map.get(9));
            plat.add(map.get(10));
            plat.add(map.get(12));
            plat.add(map.get(14));
            plat.add(map.get(16));
            plat.add(map.get(18));
            plat.add(map.get(20));
            plat.add(map.get(22));
            plat.add(map.get(24));
            plat.add(map.get(26));
            plat.add(map.get(28));
        }

        public Property get_index(int index){
            return plat.get(index);
        }
}
