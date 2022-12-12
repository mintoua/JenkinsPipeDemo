pipeline{
     environment { 
        registry = "jecer1997/myrepo"
        registryCredential = 'docker_id' 
        dockerImage = '' 
    }
    agent any
    stages{
        
        stage('Clone Git Repo'){
            steps{
                echo 'pulling from git ... ';
                git branch:'jecer',
                url:'https://github.com/mintoua/JenkinsPipeDemo.git';
            }
        }
        
        
        stage('Maven compile'){
            steps{
                echo 'Maven compile';
                sh "mvn compiler:compile";
                sh "mvn clean";            }
        }
        
        stage('Maven Package') {
            steps {
                sh 'mvn package'
            } 
        }
        
        stage('Maven Test'){
            steps{
                echo 'Maven test';
                sh 'mvn clean test -Dtest=tn.esprit.rh.services.OperateurServiceMockTest -DfailIfNoTests=false' 
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
                sh "mvn deploy ";
            }
        }
        
        stage('Build Docker Image'){
             steps {
                   script{
          	          sh 'docker image build  -t jecer1997/app .  '
                   }
             }
         }
         
         stage('Docker login') {
              steps {
                   script {
                         sh 'docker login -u jecer1997 -p 4CDP25fun'
                   }
              }
         }

         stage('Pushing Docker Image') {
              steps {
                   script {
                        sh 'docker push jecer1997/app'
                           }
              }
          }

          stage('Run Spring && MySQL Containers') {
                steps {
                      script {
                             sh 'docker-compose up -d'
                             }
                      }
          }
         
    } 
    }

