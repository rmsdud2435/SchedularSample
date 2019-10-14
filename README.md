# Spring5-SchedularSample
Quartz Scheduling 관련하여 테스트 및 활용하기 위한 샘플

## 특이사항

### SimpleService의 printHelloWorld()

실행 시간이 얼마 걸리지 않는 Job 테스트를 위한 메소드


### SimpleService의 sleepFor10seconds()

실행 시간이 오래 걸리는 Job 테스트를 위한 메소드

### @DisallowConcurrentExecution

@DisallowConcurrentExecution을 활용하여 중복제거
