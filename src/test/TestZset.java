import com.redis.redisinaction.Constants;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/10.
 */
public class TestZset {

    public static void main(String[] args) {
        Jedis conn = new Jedis(Constants.REDIS_URL);
        conn.select(11);
        Set<Tuple> myzset2 = conn.zrangeWithScores("myzset2", 0, -1);
        for (Tuple tuple : myzset2) {
            System.out.println("member:"+ tuple.getElement()+" & score:"+ tuple.getScore());
        }
        System.out.println(".................................");
        Long zrank = conn.zrevrank("myzset2", "bb");
        System.out.println("rank:"+zrank);


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Tuple myzset1 : conn.zrangeWithScores("myzset1", 0, -1)) {
            System.out.println("member:"+ myzset1.getElement()+"  score:"+myzset1.getScore());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Double zincrby = conn.zincrby("myzset1", 111.11d, "aa");
        Set<Tuple> myzset1 = conn.zrangeWithScores("myzset1", 0, -1);
        for (Tuple tuple : myzset1) {
            System.out.println("member:"+ tuple.getElement()+"  score:"+tuple.getScore());
        }
    }
}
