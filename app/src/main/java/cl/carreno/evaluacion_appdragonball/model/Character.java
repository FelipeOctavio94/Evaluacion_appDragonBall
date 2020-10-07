package cl.carreno.evaluacion_appdragonball.model;

public class Character {

        public String name;
        public String gender;
        public String originPlanet;
        public String species;
        public String image;

        public Character(){}

    public Character(String name, String gender, String originPlanet, String species, String image) {
        this.name = name;
        this.gender = gender;
        this.originPlanet = originPlanet;
        this.species = species;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
