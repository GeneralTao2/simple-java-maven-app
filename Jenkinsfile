pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
        buildDiscarder(logRotator(numToKeepStr: '30'))
        timestamps()
    }

    tools {
        maven 'maven-3.8.6'
    }

    parameters {
        string(
            name: "Branch_Name",
            defaultValue: 'master',
            description: '')

        string(
            name: "Image_Name",
            defaultValue: 'simple-java-maven-app',
            description: '')

        string(
            name: "Image_Tag",
            defaultValue: 'latest',
            description: 'Image tag')

        booleanParam(
           name: "PushImage",
           defaultValue: true)
    }

    stages {


        stage("Build docker images") {
            steps {
                script {
                    echo "Bulding docker images"
                        def buildArgs = """\
                            -f Dockerfile \
                            ."""
                        def image = docker.build(
                            "${params.Image_Name}:${params.Image_Tag}",
                            buildArgs)
                }
            }
        }
        stage("Push to Dockerhub") {
            when {
                equals expected: "true",
                actual: "${params.PushImage}"
            }
            steps {
                script {
                    echo "Pushing the image to docker hub"
                    def localImage = "${params.Image_Name}:${params.Image_Tag}"
                    def repositoryName = "generaltao725/${localImage}"

                    sh "docker tag ${localImage} ${repositoryName} "

                }
            }
        }
    }
    post {
        always {
            script {
                echo 'I will always say Hello again!'
                    def localImage = "${params.Image_Name}:${params.Image_Tag}"
                    sh "docker rmi -f generaltao725/${localImage} ${localImage}"
            }
        }
    }
}