pipeline {
    agent any


    stages {


        stage('MVN CLEAN') {
            steps {

              script {

                  sh 'mvn  clean'


                      }
                   }
         }
          stage('MVN compile') {
            steps {

              script {

                  sh 'mvn compile'


                      }
                   }
         }
          stage('MVN test') {
            steps {

              script {

                  sh 'mvn  test'


                      }
                   }
         }

          stage('Artifact Construction') {
                      steps{
                          sh "mvn -B -DskipTests  package "
                      }
                  }
                  stage('sonar') {
                              steps{
                                  sh "mvn sonar:sonar -Dsonar.projectKey=sonarqube -Dsonar.host.url=http://192.168.43.40:9000/ -Dsonar.login=457043f6eff47ed35df651e306450be2b2f28f84"
                              }
                          }
/*
        stage('SONAR') {
            steps {

              script {

                  sh 'mvn  sonar:sonar  -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://192.168.43.40:9000/ -Dsonar.login=admin   -Dsonar.password=sonar'


                      }
                   }

         }*/
         stage('nexus') {
            steps {

              script {

sh 'mvn -DskipTests deploy  -e'                      }
                   }
         }
         stage('Build Docker Image'){
                      steps {
                          script{
          				    sh 'docker image build  -t salem13/backcicd .  '
                          }
                      }
          		}
          		stage('Docker login') {
                                steps {
                                    script {

                                        sh 'docker login -u salem13 -p azerty123.'}
                                }
                                }
                                /*
                          stage('Pushing Docker Image') {
                                steps {
                                    script {

                                     sh 'docker push salem13/backcicd'
                                    }
                          }*/

                          stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up -d'
                                    }
                                }
                            }
     }

     }