
### 添加数据

> 这个是描述

请求方式|接口地址|请求格式|返回格式|说明
:---|:---|:---|:---|:---
post|/api/v1/demo|json|json|添加数据

> 请求参数

参数名|类型|必传|说明
:---|:---|:---|:---
name|string|是|名称

> 请求示例
```json
{
  "name": "test"
}
```

> 返回示例
```json
{
  "code": 200,
  "data": 1
}
```


### 查询列表

> 这个是描述

请求方式|接口地址|请求格式|返回格式|说明
:---|:---|:---|:---|:---
get|/api/v1/list|url|json|查询列表

> 请求参数:

|参数名|类型|必传|说明|
|:---|:---|:---|:---|
|offset|int|是|从第几条开始|
|limit|int|是|一页显示多少条|

> 请求示例

```
/api/v1/list?pageNum=1&limit=10
```

> 返回示例
```json
{
    "code": 0,
    "msg": "ok",
    "data": {
        "total": 0,
        "list": [
            {
                "id": 2,
                "mailid": 1231231231,
                "mailName": "xx商场",
                "createUser": "张三",
                "updateUser": null,
                "isDel": 0,
                "creator": 2,
                "createDate": "2020-12-06 08:09:57",
                "updater": null,
                "updaterDate": null,
                "version": 0
            }
        ]
    }
}
```
