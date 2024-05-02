Following this guide

https://www.baeldung.com/spring-boot-start

https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html

## 2024-04-29 

- [X] Wrote working tests
- [X] Spun up EC2 on AWS
- [X] Installed Java SDK on EC2
- [X] Get executable JAR file
	- https://www.marcobehler.com/guides/mvn-clean-install-a-short-guide-to-maven
	- Have you set your JAVA_HOME?? https://www.geeksforgeeks.org/deploy-a-spring-boot-application-with-aws/

- [X] Load the JAR file into EC2
	- [X] chmod the permission key
	- [X] scp the file to the EC2
	- [X] Run. It works! Access to public IP address and port ()
	- [X] Adjust the privacy settings to accept TCP over Port 8080. Port accessible online over http! WOW!!
		- "http://52.91.250.73:8080"
	- [X] [Install Docker](https://stackoverflow.com/questions/53918841/how-to-install-docker-on-amazon-linux2)
	- [X] [Install Docker Compose](https://stackoverflow.com/questions/63708035/installing-docker-compose-on-amazon-ec2-linux-2-9kb-docker-compose-file)
	
- [X] Connect SQL DB and create docker compose image (Docker Compose)
	- [X] Switch h2 db to postgresql
	- [ ] Upload docker compose to hosting platform.
	-	https://www.baeldung.com/spring-boot-postgresql-docker

```
ssh -i /Users/cpadilla/Downloads/main-keypair.pem  ec2-user@ec2-52-91-250-73.compute-1.amazonaws.com
```

```
scp -i /Users/cpadilla/code/java/spring-boot-hello-world/target/demo-0.0.1-SNAPSHOT.jar /Users/cpadilla/Downloads/main-keypair.pem   ec2-user@ec2-52-91-250-73.compute-1.amazonaws.com:~/
```

- [ ] `nohup` to keep the application running.

```
nohup java -jar file.jar > application.log &
```

To Kill nohup process, lookup the process with:

```
ps -ef
```

then find the PID of the script you ran (`java --jar app.jar`)

Scrapping manual AWS... Going with Elastic Bean Stalk

Follow this guide for deployment:

https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/

Deployment is a nice to have... don't prioritize just yet.

We did it! Elastic Beanstalk makes life 1000 times easier!! Woohooo!!

Next: Chosing a DB and deploying with AWS


Other refs:

How to deploy Spring-boot to EC2
https://medium.com/@intruder2021/how-to-deploy-a-spring-jar-file-on-amazon-ec2-instance-so-it-can-run-even-we-close-the-terminal-2aa0efa09ac8#:~:text=Run%20the%20JAR%20file%3A%20Connect,using%20the%20java%20%2Djar%20command.&text=This%20will%20start%20your%20Spring,by%20accessing%20the%20appropriate%20endpoint.

Basic EC2 Usage
https://www.youtube.com/watch?v=oHAQ3TzUTro&ab_channel=SamMeech-Ward

rsync for ssh deployment
https://gist.github.com/kamranahmedse/1e94b412006040f38e24b9443b2da41a

- https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/connect-linux-inst-ssh.html
- https://medium.com/@amitu2016/deploying-spring-boot-web-app-on-aws-using-ec2-and-s3-4db1d0f55c78