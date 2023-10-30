import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddAllList {
    public static void main(String[] args) {
        // 模拟从 param 获取的 sourceCols
        List<Map<String, Object>> sourceCols = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", "value1");
        sourceCols.add(map1);

        // 模拟从 param 获取的 derSourceCols
        List<Map<String, Object>> derSourceCols = new ArrayList<>();
        Map<String, Object> map2 = new HashMap<>();
        map2.put("key2", "value2");
        derSourceCols.add(map2);

        // 合并 sourceCols 和 derSourceCols 列表
        sourceCols.addAll(derSourceCols);

        // 打印合并后的列表
        for (Map<String, Object> map : sourceCols) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
