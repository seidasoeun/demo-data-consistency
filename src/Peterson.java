public class Peterson {
    private final boolean[] flag = new boolean[2];
    private volatile int turn;

    public void lock(int i) {
        int j = 1 - i;
        flag[i] = true;
        turn = j;
        while (flag[j] && turn == j) {
            Thread.yield();
        }
    }

    public void unlock(int i) {
        flag[i] = false;
    }
}
