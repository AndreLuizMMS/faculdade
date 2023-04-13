package POO.Polimorfismo;

class Animal {
  public void comer() {
    System.out.println("Animal comendo...");
  }
}

class Cachorro extends Animal {
  public void comer() {
    System.out.println("Cachorro comendo...");
  }

}

class Gato extends Animal {
  public void comer() {
    System.out.println("Gato comendo...");
  }
}

public class PoliAnimal {

  public static void animalComendo(Animal animal) {
    animal.comer();
  }

  public static void main(String[] args) {
    Animal cachorro = new Cachorro();
    Animal gato = new Gato();

    animalComendo(cachorro);
    animalComendo(gato);
  }

}
