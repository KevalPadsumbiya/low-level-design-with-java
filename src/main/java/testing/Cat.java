package testing;

public class Cat implements Animal {

    String animalName;

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public void getAnimalName() {
        System.out.println(animalName);
    }

}
