import java.time.LocalDateTime;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String naam, int releaseJaar, double nieuwprijs){
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public String getNaam(){
        return naam;
    }
    public double huidigeWaarde(){
        double prijs = 0.0;
        double perJaarkorting = 0.3;
        if (releaseJaar == LocalDateTime.now().getYear()){
            return nieuwprijs;}
        else{
            int divJaar = LocalDateTime.now().getYear() - releaseJaar;
            for (int i = divJaar;i > 0; i--){
                prijs += nieuwprijs - (nieuwprijs * perJaarkorting);
            }

            return (prijs);}
    }
    public boolean equals(Object andereObject){
        if (andereObject instanceof Game) {
            if (((Game) andereObject).naam.equals(getNaam())){
                if (((Game) andereObject).releaseJaar == releaseJaar){
                        return true;}}}
        else;
            return false;

        }

    public String toString(){
        return(naam +", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde()));
    }
}
