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

        stage('SONAR') {
            steps {

              script {

                  sh 'mvn  sonar:sonar  -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://192.168.43.40:9000/ -Dsonar.login=admin   -Dsonar.password=sonar'


                      }
                   }

         }
         stage('nexus') {
            steps {

              script {

sh 'mvn -DskipTests deploy  -e'                      }
                   }
         }
      /*    stage('Build Docker Image'){
                      steps {
                          script{
          				    sh 'docker image build . -t haifa123456/backcicd -f backend-spring/Dockerfile '
                          }
                      }
          		}
          		stage('Docker login') {
                                steps {
                                    script {

                                        sh 'docker login -u haifa123456 -p haifabrineg'}
                                }
                                }
                          stage('Pushing Docker Image') {
                                steps {
                                    script {

                                     sh 'docker push haifa123456/backcicd'
                                    }
                                }
                          }
                          stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh ' docker-compose -f backend-spring/docker-compose.yml up -d '
                                    }
                                }
                            }*/
     }

     }