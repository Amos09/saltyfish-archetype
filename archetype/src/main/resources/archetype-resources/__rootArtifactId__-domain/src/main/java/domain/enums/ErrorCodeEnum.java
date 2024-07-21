#set($symbol_pound='#')
        #set($symbol_dollar='$')
        #set($symbol_escape='\' )
        package ${package}.domain.enums;

import com.saltyfish.framework.common.exception.IResultCode;
import lombok.AllArgsConstructor;

/**
 * 状态码枚举
 *
 * @author: 番薯(Amos)
 * @date: 10:15/09:03:2023
 */
@AllArgsConstructor
public enum ErrorCodeEnum implements IResultCode {

    SUCCESS(200, "操作成功"), SYSTEM_ERROR(500, "系统异常"), DATA_NOT_EXISTS(1004001000, "数据不存在"),

    ;

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
