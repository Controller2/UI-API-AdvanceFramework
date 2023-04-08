pipeline{

               agent any

                    stages{

                         stage('compile stage'){

                           steps{
                                     withMaven(maven :'3.21')
                                     sh 'mvn test'
                               }


                                      }


      }
      
      }






}