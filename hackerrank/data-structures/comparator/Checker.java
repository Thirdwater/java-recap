class Checker implements Comparator<Player> {

    @Override
    public int compare (Player player1, Player player2) {
        if (player1.score == player2.score) {
            return player1.name.compareTo(player2.name);
        }
        return player2.score - player1.score;
    }

}

class Player {

    String name;
    int score;

}
