# Spring5-SchedularSample
Quartz Scheduling 관련하여 테스트 및 활용하기 위한 샘플

## 사용된 버전

>java : 1.8.X  
>spring : 5.0.X  
>quartz : 2.3.X


## 특이사항

### SimpleService의 printHelloWorld()

실행 시간이 얼마 걸리지 않는 Job 테스트를 위한 메소드


### SimpleService의 sleepFor10seconds()

실행 시간이 오래 걸리는 Job 테스트를 위한 메소드

### simpleCronTrigger Bean 객체

@DisallowConcurrentExecution을 활용하여 중복제거.  
만약, 이미 실행되고 있다면 배치 대기열에 추가 후 이전 배치 끝나자 마자 바로 실행

### simpleCronTrigger2 Bean 객체

JobExecutionContext 객체를 활용하여 중복제거.  
만약, 이미 실행되고 있다면 로직 실행하지 않고 다음 배치 시간을 디다림
