pipeline {
    tools{
        maven 'M2_HOME'
    }
    environment { 
        registry = "mta24/achatapp" 
        registryCredential = 'dockerhub_id' 
        dockerImage = '' 
    }
    agent any

    stages {
        stage('Git') {
            steps {
                git url: 'https://github.com/mintoua/JenkinsPipeDemo.git', branch: 'mintoua'
            }
        }
        stage('Maven Clean/Install') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Maven Package') {
            steps {
                sh 'mvn package'
            } 
        }
        stage('Maven Test/Mockito') {
            steps {
                sh 'mvn clean test'
                //sh 'mvn clean test -Dtest=tn.esprit.rh.services.ProduitServiceMockTest' 
            }
        }
         stage('Maven Test/JUnit') {
            steps {
                sh 'mvn test'
                //sh 'mvn clean test -Dtest=tn.esprit.rh.services.ProduiServiceImplTest -Dmaven.test.failure.ignore=true'  
            }
        }
        stage('CodeQuality SonarQube') {
            steps {
                sh 'mvn sonar:sonar  -Dsonar.login=admin -Dsonar.password=sonar'  
            }
        } 
       stage('DeployArtefact Nexus'){
            steps{
                sh 'mvn deploy -DskipStaging=true'
            }
        } 
        stage('Docker Enable CD'){
            steps{
                //sh 'sudo chmod 666 /var/run/docker.sock'
                //sh 'sudo chmod +x /usr/local/bin/docker-compose'
                sh 'docker-compose --version'
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
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
        stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
    }
    post 
    {
        always {
            echo 'This will always run'
                }
        success {
            mail to: "toupkandi.mintoua@esprit.tn",
                     subject: "Success",
                     body: "Succes on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER} "        
                }
        failure {
                    mail to: "toupkandi.mintoua@esprit.tn",
                     subject: "Failure",
                     body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "     
                }
    }
}