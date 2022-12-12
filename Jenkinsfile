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
        
        stage('Building Docker image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
        stage('Deploy image') { 
            steps { 
                    sh "docker push jecer1997/myrepo";
                } 
            }

        stage('Run up') { 
            steps {
                sh "docker run -d -p 5004:5000 $registry:$BUILD_NUMBER" 
            }
        }
    } 
    }

