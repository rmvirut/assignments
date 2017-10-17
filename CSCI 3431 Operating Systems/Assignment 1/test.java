public class test {

static boolean blocked [];
static int turn;

    public static void main (String [] args) {
        blocked[0] = false;
        blocked[1] = false;
        turn = 0;
    }

    static void P(int id){
        blocked[id] = true;
        while(turn!=id){
            
            while(blocked[1-id]){
                // wait for P1 to become false
            }
            turn = id;
        }

        // critical section
        blocked[id] = false;
        // remainder section
    }

}