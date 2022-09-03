pipeline {
    agent {
        node {
            label 'built-in'
        }
    }
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
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage("Build docker images") {
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