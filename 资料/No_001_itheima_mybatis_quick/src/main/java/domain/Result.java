package domain;

import java.util.List;

/**
 * @author XUAN
 * @date 2020/11/20 - 19:51
 * @references
 * @purpose
 * @errors
 */
public class Result {
    private int id;
    private int avg_remaining;
    private int avg_integral;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvg_remaining() {
        return avg_remaining;
    }

    public void setAvg_remaining(int avg_remaining) {
        this.avg_remaining = avg_remaining;
    }

    public int getAvg_integral() {
        return avg_integral;
    }

    public void setAvg_integral(int avg_integral) {
        this.avg_integral = avg_integral;
    }

    public int countAvg_remaining(List<User> userList) {
        int avg=0;
        for (User user:userList){
            avg+=user.getRemaining();
        }
        return avg;
    }


    public int countAvg_integral(List<User> userList) {
        int biggest=0;
        int least=0;
        for (User user:userList){
            least = Math.min(user.getIntegral(), least);
            biggest = Math.max(user.getIntegral(), least);
        }
        return biggest - least;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", avg_remaining=" + avg_remaining +
                ", avg_integral=" + avg_integral +
                '}';
    }
}
