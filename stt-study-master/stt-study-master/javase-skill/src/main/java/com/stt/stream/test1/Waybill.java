package com.stt.stream.test1;

import java.math.BigDecimal;

/**
 * @date 石添
 * @date 2023/12/23
 */
public class Waybill {
    // id
    private Long id;
    // 运单编号
    private String wayNo;
    // 运费
    private BigDecimal price;
    // 货物类型
    private String freightType;
    // 距离
    private BigDecimal distance;
    // 目的地
    private String endAddress;

    public Waybill(Long id, String wayNo, BigDecimal price, String freightType, BigDecimal distance, String endAddress) {
        this.id = id;
        this.wayNo = wayNo;
        this.price = price;
        this.freightType = freightType;
        this.distance = distance;
        this.endAddress = endAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWayNo() {
        return wayNo;
    }

    public void setWayNo(String wayNo) {
        this.wayNo = wayNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFreightType() {
        return freightType;
    }

    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    @Override
    public String toString() {
        return "Waybill{" +
                "id=" + id +
                ", wayNo='" + wayNo + '\'' +
                ", price=" + price +
                ", freightType='" + freightType + '\'' +
                ", distance=" + distance +
                ", endAddress='" + endAddress + '\'' +
                '}';
    }
}
