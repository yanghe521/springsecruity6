package com.stt.stream.test1;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date 石添
 * @date 2023/12/23
 */
public class StreamMain {
    private static List<Waybill> waybills = new ArrayList<>();

    static {
        // 创建数据
        waybills.add(new Waybill(1L,"Y11111111111",new BigDecimal(1000),"钢材",new BigDecimal(200),"上海市"));
        waybills.add(new Waybill(2L,"Y22222222222",new BigDecimal(2000),"钢材",new BigDecimal(300),"郑州市"));
        waybills.add(new Waybill(3L,"Y33333333333",new BigDecimal(3000),"水泥",new BigDecimal(500),"北京市"));
        waybills.add(new Waybill(4L,"Y44444444444",new BigDecimal(4000),"水泥",new BigDecimal(400),"广州市"));
        waybills.add(new Waybill(5L,"Y55555555555",new BigDecimal(5000),"沙子",new BigDecimal(500),"上海市"));
        waybills.add(new Waybill(6L,"Y66666666666",new BigDecimal(6000),"板材",new BigDecimal(300),"深圳市"));
        waybills.add(new Waybill(7L,"Y77777777777",new BigDecimal(7000),"蔬菜",new BigDecimal(500),"杭州市"));
    }
    public static void main(String[] args) {
        // 1、获取运费大于5000的运单
//        Stream<Waybill> stream = waybills.stream().filter(item -> item.getPrice().compareTo(new BigDecimal("5000")) != -1);
//        // 获取数据，将数据转换到集合中
//        List<Waybill> newList = stream.toList();
//        newList.forEach(System.out::println);

        // 2、将推荐运单按照运费从低到高排序
//        List<Waybill> sorted1List = waybills.stream().sorted(((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))).collect(Collectors.toList());
//        sorted1List.forEach(System.out::println);
        // 降序排序
//        List<Waybill> sorted2List = waybills.stream().sorted(Comparator.comparing(Waybill::getPrice).reversed()).collect(Collectors.toList());
//        sorted2List.forEach(System.out::println);

        // 3、只想获取运单编号
//        List<String> snList = waybills.stream().sorted(Comparator.comparing(Waybill::getPrice).reversed()).map(Waybill::getWayNo).toList();
//        snList.forEach(System.out::println);

        // 4、先按照距离排序，再按照价格排序
//        List<Waybill> sorted3List = waybills.stream().sorted(Comparator.comparing(Waybill::getDistance)
//                .thenComparing(Comparator.comparing(Waybill::getPrice).reversed())).collect(Collectors.toList());
//        sorted3List.forEach(System.out::println);

        // 5、获取最高运费
        Optional<Waybill> max = waybills.stream().max(Comparator.comparing(Waybill::getPrice));
        System.out.println("max====>" + max);
        // 6、获取最低运费
        Optional<Waybill> min = waybills.stream().min(Comparator.comparing(Waybill::getPrice));
        System.out.println("min====>" + min);
        // 8、计算平均运费
        Double avgPrice = waybills.stream().collect(Collectors.averagingDouble(item -> item.getPrice().doubleValue()));
        System.out.println("平均运费=======》" + avgPrice);
    }
}
