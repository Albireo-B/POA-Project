package RoyaumeDesBonbons.bonbon;

public final class Ingredient {

    private String nom;

    public Ingredient(String newNom) {
        setNom(newNom);
    }

    public String GetNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Ingredient other = (Ingredient) obj;
        return other.GetNom() == this.GetNom();
    }

    @Override
    public String toString() {
        return this.GetNom();
    }

    @Override
    public int hashCode() {
        return GetNom() != null ? GetNom().hashCode() : 0;
    }
}
