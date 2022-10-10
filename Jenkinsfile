node{
    def WORKSPACE = "/var/lib/jenkins/workspace/springboot-deploy"
    def dockerImageTag = "springboot-deploy{env.BUILD_NUMBER}"

    try{

        stage('Clone Repo'){

            git url: 'https://github.com/mintoua/JenkinsPipeDemo.git', branch: 'master'
        }
        stage('Build docker'){

            dockerImage =  docker.build("springboot-deploy:${env.BUILD_NUMBER}")
        }
        stage('Deploy docker'){
            echo "Docker Image Tage Name: ${dockerImageTag}"
            sh "sudo docker stop springboot-deploy || true && docker rm springboot-deploy || true"
            sh "sudo docker run --name springboot-deploy -d -p 8081:8080 springboot-deploy:${env.BUILD_NUMBER}"
        }

    }catch(e){
        throw e
    }
}