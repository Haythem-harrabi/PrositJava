package tn.esprit.gestion.Entite;
import java.lang.Exception;
public class Zoo {

   private String name,city;
   private int nbrCages;
  private  int nbrAnimal=0;
   private Animal [] animals;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void setNbrCages(int nbrCages) {
        this.nbrCages = nbrCages;
    }

    public int getNbrAnimal() {
        return nbrAnimal;
    }

    public void setNbrAnimal(int nbrAnimal) {
        this.nbrAnimal = nbrAnimal;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public static int getNbTotalAn() {
        return nbTotalAn;
    }

    public static void setNbTotalAn(int nbTotalAn) {
        Zoo.nbTotalAn = nbTotalAn;
    }

    private Aquatic [] AquaticAnimals = new Aquatic [10];



    private static int nbTotalAn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zoo(int nbrCages, String name, String city)
    {

        this.nbrCages=nbrCages;
        this.name=name;
        this.city=city;

        animals=new Animal[nbrCages];

    }
    public Zoo()
    {
        animals=new Animal[25];
    }

    public void addAnimal(Animal a) throws Exception
    {

            if (this.isFull()){
                throw new ZooFullException();
            }
            else if (a.getAge()<0) {
                throw new InvalidAgeException();

            } else {
            this.animals[this.nbrAnimal] = a;
            this.nbrAnimal++;
            nbTotalAn++;
            }
            System.out.println(this.getNbrAnimal());

        }




    public static int nbTotal()
    {

        return nbTotalAn;
    }
    public void display()
    {

        System.out.println("city :"+city+" name :"+name);
        for (int i=0;i<animals.length;i++) {
            if (animals[i]!=null)
                System.out.println(animals[i].getName());
        }
    }

    public  String toString()
    {
        String str="Les animaux :\n";
        //for (int i=0;i<nbrAnimal;i++)
          //str+=animals[i]+"\n";
   for (Animal a:animals) {
       if(a!=null)
        str += a + "\n";
   }
        return "city :"+city+" name :"+name+"\n"+str;
    }

    public int searchAnimal(Animal a)
    {

        for(int i=0;i<nbrAnimal;i++)
        {

            if(animals[i].equals(a))
                return i;
        }
        return -1;
    }
    public boolean removeAnimal(Animal a)
    {

        int indexAnimal=searchAnimal(a);
        if (indexAnimal==-1)
            return false;
        for (int i=indexAnimal;i<nbrAnimal;i++)
            animals[i]=animals[i+1];
        animals[nbrAnimal]=null;
        this.nbrAnimal--;
        return true;
    }
    public Zoo comparerZoo(Zoo z1)
    {
      if(this.nbrAnimal>z1.nbrAnimal)
          return this;
      else if(this.nbrAnimal<z1.nbrAnimal)
      return z1;
      return null;

    }
    public static Zoo comparerZoo(Zoo x,Zoo z2)
    {
        if(z2.nbrAnimal>x.nbrAnimal)
            return z2;
        else if(z2.nbrAnimal<x.nbrAnimal)
            return x;
        return null;
    }


    public boolean isFull()
    {
        if(this.getNbrAnimal()==this.getAnimals().length)
            return true;
        return false;
    }

    public void addAquaticAnimal(Aquatic aquatic){
        int nbr=0;
        for (int i=0;i<this.AquaticAnimals.length;i++){
            if (AquaticAnimals[i]!=null)
                nbr++;
        }
        if (nbr<10){
            this.AquaticAnimals[nbr]=aquatic;
        }
        else
            System.out.println("Impossible d'ajouter cet animal");

    }

    public Aquatic[] getAquaticAnimals() {
        return AquaticAnimals;
    }

    public void setAquaticAnimals(Aquatic[] aquaticAnimals) {
        AquaticAnimals = aquaticAnimals;
    }


    public float maxPenguinSwimmingDepth(){
       float max=0;
        for (int i=0;i<this.AquaticAnimals.length;i++){
            if (AquaticAnimals[i]!=null&&AquaticAnimals[i].getClass().equals(Penguin.class)){
                if (((Penguin)AquaticAnimals[i]).getSwimmingD()>max)
                    max= ((Penguin)AquaticAnimals[i]).getSwimmingD();}
        }
        return max;
    }
    
    
    public void displayNumberOfAquaticsByType(){
        int d=0;
        int p=0;
        for (int i=0;i<this.AquaticAnimals.length;i++){
            if (AquaticAnimals[i]!=null){
                if (AquaticAnimals[i] instanceof Penguin)
                    p++;
                else if (AquaticAnimals[i] instanceof Dolphin) {
                    d++;
                }
            }

        }
        System.out.println("le nombre des dauphins dans ce zoo est"+d);
        System.out.println("le nombre des penguins dans ce zoo est"+p);
    }
}
