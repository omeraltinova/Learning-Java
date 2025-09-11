package Section12.Generics;

interface Player{

    String name();

}

record BaseballPlayer(String name,String position) implements Player{}

record FootballPlayer(String name,String position) implements Player{}

record VolleyballPlayer(String name,String position) implements Player {}


public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city","Philadelphia, PA","US");
        BaseballTeam phllies1 = new BaseballTeam("Phi");
        BaseballTeam astros1 = new BaseballTeam("Astro");
        scoreResult(phllies1,3,astros1,5);

        SportsTeam phllies2 = new SportsTeam("Phi");
        SportsTeam astros2 = new SportsTeam("Astro");
        scoreResult(phllies2,3,astros2,5);

        Team<BaseballPlayer,Affiliation> phllies = new Team<>("Phi",philly);
        Team<BaseballPlayer,Affiliation> astros = new Team<>("Astro");
        scoreResult(phllies,3,astros,5);


        var harper = new BaseballPlayer("B harper","Right Fielder");
        var marsh = new BaseballPlayer("B Marsh","Right Fielder");
        phllies.addTeamMember(harper);
        phllies.addTeamMember(marsh);
        phllies.listTeamMembers();



        SportsTeam afc1 = new SportsTeam("Team1");
        Team<FootballPlayer,Affiliation> afc = new Team<>("Team1");
        var tex = new FootballPlayer("Tex","Centre");
        var  rory = new FootballPlayer("Rory","Centre");
        afc.addTeamMember(rory);
        afc.addTeamMember(tex);
        afc.listTeamMembers();

        Team<VolleyballPlayer,Affiliation> adelaide = new Team<>("Adelaide");
        adelaide.addTeamMember(new VolleyballPlayer("N roberts","Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer,Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black","Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra,0,adelaide,1);

    }

    public static void scoreResult(BaseballTeam team1,int t1_score,BaseballTeam team2,int t2_score){
    String message = team1.setScore(t1_score,t2_score);
    team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);

    }

    public static void scoreResult(SportsTeam team1,int t1_score,SportsTeam team2,int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);

    }

    public static void scoreResult(Team team1,int t1_score,Team team2,int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);

    }
}
