pipeline{
    agent any
    stages{
        
        stage('Clone Git Repo'){
            steps{
                echo 'pulling from git ... ';
                git branch:'main',
                url:'https://github.com/JecerBenH/app.git';
            }
        }
        
        
        stage('Maven compile and clean'){
            steps{
                echo 'Maven compile';
                sh "mvn compiler:compile";
                sh "mvn clean";
            }
        }
        
        stage('Maven Test'){
            steps{
                echo 'Maven test';
                sh "mvn test";               
            }
        }
        
        stage('SonarQube'){
            steps{
                echo 'Maven Sonar';
                sh "mvn sonar:sonar -Dsonar.login=38ac039765f3484c0b7dc83d21af18ed08837cb5";
            }
        }
        
        stage(' Maven Build / Nexus'){
            steps{
                echo 'Install and Deployement';
                sh "mvn deploy -e";
            }
        }
    }
}
