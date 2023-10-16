package tn.esprit.gestion.Entite;

public class TestAnimal {

    public static void main(String[] args) {
        System.out.println("Dolp");
        Dolphin d1=new Dolphin();
        System.out.println("Terrs");
        Terrestre ter1=new Terrestre();

        Terrestre ter2=new Terrestre(1,"chat","couc",true,4);

        System.out.println(ter2);




        System.out.println(d1);



        Penguin p1=new Penguin(2.6F);
        Penguin p2=new Penguin(7.5F);

//        aqu1.swim();
//        d1.swim();
//        p1.swim();



        Zoo zoo1= new Zoo(3,"zoo1","City1");


        zoo1.addAquaticAnimal(p2);
        zoo1.addAquaticAnimal(d1);
        zoo1.addAquaticAnimal(p1);
        System.out.println("//////////////////////////////////////////////////////////////");
        for (int i=0;i<zoo1.getAquaticAnimals().length;i++){
            if (zoo1.getAquaticAnimals()[i]!=null)
                zoo1.getAquaticAnimals()[i].swim();
        }

        System.out.println(zoo1.maxPenguinSwimmingDepth());

        zoo1.displayNumberOfAquaticsByType();
    }
}
