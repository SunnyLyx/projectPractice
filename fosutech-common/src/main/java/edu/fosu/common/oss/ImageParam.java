package edu.fosu.common.oss;


/**
 * 图像处理参数类
 */
public class ImageParam {
    /**
     * 宽
     *
     */
    private Integer w;
    /**
     * 高
     */
    private Integer h;
    /**
     * 横坐标
     */
    private Integer x;
    /**
     * 纵坐标
     */
    private Integer y;
    /**
     *  设置裁剪的原点位置，由九宫格的格式，一共有九个地方可以设置，
     *  每个位置位于每个九宫格的左上角[nw, north, ne, west, center, east, sw, south, se]
     */
    private String g;


    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }
}
