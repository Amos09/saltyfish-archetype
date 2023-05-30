#### ***网关实现，解耦利器***
```
public class UserClientProxy {

    @Resource
    private UserClientService userClientService;
    @Resource
    private UserClientAdapter userIntegrationAdapter;

    // 查询用户
    public UserBaseInfoVO getUserInfo(String userId) {
        UserInfoClientDTO user = userClientService.getUserInfo(userId);
        UserBaseInfoVO result = userIntegrationAdapter.convert(user);
        return result;
    }
}
```