package com.mujuezhike.projectm.base.object.enums;

/** 
 * @author   : mujuezhike 
 * @date     : 20171019
 * @describe : 列业务类型 
 * @type     : Enum  
 */
public enum TColumnColumnEnum {
	
	KEYVALUE          (10,"键值对" ),
	CHILD             (11,"子项"),
	LIST              (21,"列表"),
	
	;
    private Integer num;
    
    private String describe;
	
	private TColumnColumnEnum(Integer num,String describe) {
        this.num = num;
        this.describe = describe;
	}

	public Integer num() {
		return num;
	}

	public String describe() {
		return describe;
	}
	
	// 把整数映射到枚举值
    /** @20161104    通过数据库的状态值   获取相应的 enum byte **/
    public static TColumnColumnEnum valueOf(byte value) {
        for(TColumnColumnEnum typeEnum : TColumnColumnEnum.values()) {
            if(typeEnum.num() == value) {
                return typeEnum;
            }
        }
        return null; 
    }
    
    // 把整数映射到枚举值
    /** @20161104    通过数据库的状态值   获取相应的 enum int **/
    public static TColumnColumnEnum valueOf(int value) {
        for(TColumnColumnEnum typeEnum : TColumnColumnEnum.values()) {
            if(typeEnum.num() == value) {
                return typeEnum;
            }
        }
        return null; 
    }
    
    public static void main(String[] args){
        int b = 11;
        String s = TColumnColumnEnum.valueOf(b).describe;
        System.out.println(s);
        byte bs = 21;
        String ss = TColumnColumnEnum.valueOf(bs).describe;
        System.out.println(ss);

    }


}
