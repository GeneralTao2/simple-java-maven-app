pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
        buildDiscarder(logRotator(numToKeepStr: '30'))
        timestamps()
    }

    parameters {
        string(
            name: "Branch_Name",
            defaultValue: 'master',
            description: '')

        string(
            name: "Image_Name",
            defaultValue: 'generaltao725/simple-java-maven-app',
            description: '')

        string(
            name: "Image_Tag",
            defaultValue: 'latest',
            description: 'Image tag')

        booleanParam(
           name: "PushImage",
           defaultValue: false)
    }

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage("Build docker images") {
            agent {
                node {
                    label 'built-in'
                }
            }
            steps {
                script {
                    echo "Bulding docker images"
                        def buildArgs = """\
                            -f Dockerfile \
                            ."""
                        docker.build(
                            "${params.Image_Name}:${params.Image_Tag}",
                            buildArgs)
                }
            }
        }
    }
}