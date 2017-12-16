Step1:打包工程

    mvn clean package -DskipTests

Step2:加入peer1,peer2到hosts中。
    
    127.0.0.1 peer1
    127.0.0.1 peer2
Step3: 启动eureeka server:peer1,peer2

    java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1      
    java -jar ./target/eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1