pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('DockerSize') {
            steps {
                sh '''
                    docker stop vendor || true
                    docker rm vendor || true
                    docker rmi vendor || true
                    docker build -t vendor .
                    echo "vendor: build success"
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                docker run -e EUREKA_URL="${EUREKA_URL}" -e MASTER_DB_URL="${MASTER_DB_URL}/vendor" -e MASTER_DB_USERNAME="${MASTER_DB_USERNAME}" -e MASTER_DB_PASSWORD="${MASTER_DB_PASSWORD}" -e EMAIL_USERNAME="${EMAIL_USERNAME}" -e EMAIL_PASSWORD="${EMAIL_PASSWORD}" -e EMAIL_AUTH_CODE_EXPIRATION_MILLIS="${EMAIL_AUTH_CODE_EXPIRATION_MILLIS}" -e REDIS_PORT="${REDIS_PORT}" -e JWT_SECRET_KEY="${JWT_SECRET_KEY}" -e JWT_ACCESS_EXPIRATION_TIME="${JWT_ACCESS_EXPIRATION_TIME}" -e JWT_REFRESH_EXPIRATION_TIME="${JWT_REFRESH_EXPIRATION_TIME}" -d --name vendor --network gentledog vendor
                echo "vendor: run success"
                '''
                }
        }
    }
}