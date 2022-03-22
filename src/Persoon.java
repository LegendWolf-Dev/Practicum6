import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;


    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
        this.mijnGames = new ArrayList<Game>();
    }

    public double getBudget() {
        return budget;
    }

    //koop(g), maar dat kan alleen als hij voldoende budget heeft en als hij die game nog niet bezit
    public boolean koop(Game g) {
        if (getBudget() >= g.huidigeWaarde()) {
            if (mijnGames.contains(g)) {
                return false;
            } else {
                mijnGames.add(g);
                budget = budget - g.huidigeWaarde();
                return true;
            }}

        return false;
    }

//verkoop(g, koper), maar alleen als hij die game zelf heeft,
// als de koper de game nog niet heeft en als de koper voldoende budget heeft!

    public boolean verkoop(Game g, Persoon koper) {
        if (!mijnGames.contains(g)) {
            return false;
        }else{
                if (koper.koop(g)) {
                    mijnGames.remove(g);
                    budget = budget + g.huidigeWaarde();
                    return true;

                }else{
                    return false;
                }}}
    // Toevoeging Leon voor Practicum 6B
    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> arrayOfGames){
        ArrayList<Game> resultingGames = new ArrayList<>();
        for (int i = 0;  i < arrayOfGames.size(); i++){
            if (!mijnGames.contains(arrayOfGames.get(i))){
                resultingGames.add(arrayOfGames.get(i));
            }
        }
        return resultingGames;
    }
    //Einde toevoeging Leon

    public String toString() {
        String txt = "";
        int Count = this.mijnGames.size();
        for (Game game : this.mijnGames) {
            if (Count > 1) {
                 txt += game.toString() + "\n";
                 Count = Count - 1;
            } else {
                txt += game.toString();
            }}
            if (mijnGames.size() == 0) {
                return (naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:");
            } else
                return (naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:\n" + txt);
        }
    }
