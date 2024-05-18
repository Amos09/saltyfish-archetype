#### ***本项目对象 适配器***
```
// 基本对象
public class UserBaseInfoVO {
    private UserContactVO contactInfo;
    private UserAddressVO addressInfo;
}

// 地址值对象
public class UserAddressVO {
    private String cityCode;
    private String addressDetail;
}

// 联系方式值对象
public class UserContactVO {
    private String mobile;
}

```