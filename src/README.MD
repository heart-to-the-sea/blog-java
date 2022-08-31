## 项目组织结构
```
./src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── blog
│   │               ├── BlogApplication.java  启动类
│   │               ├── config                配置类
│   │               ├── controller            控制器
│   │               ├── domain                实体类
│   │               ├── dto                   数据传输对象
│   │               ├── entity                
│   │               ├── mapper                数据库访问层  mybatis
│   │               ├── respository           数据库访问层  jpa
│   │               ├── service               服务接口层
│   │               ├── utils                 工具类库
│   │               └── vo                    前端视图对象
│   └── resources
│       ├── application.yml
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── example
                └── blog
                    └── BlogApplicationTests.java
./src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── blog
│   │               ├── BlogApplication.java  启动类
│   │               ├── config                配置类
│   │               ├── controller            控制器
│   │               ├── dao                   数据接口访问层
│   │               │   ├── mapper            mybatis
│   │               │   └── respository       jpa
│   │               ├── domain                数据实体类
│   │               │   ├── domain            jpa
│   │               │   └── entity            mybatis
│   │               ├── dto                   数据传输对象
│   │               ├── service               数据服务接口层
│   │               ├── utils                 工具类库
│   │               └── vo                    前端视图包装对象
│   └── resources
│       ├── application.yml
│       ├── static
│       └── templates
├── README.MD
└── test
    └── java
        └── com
            └── example
                └── blog
                    └── BlogApplicationTests.java
```