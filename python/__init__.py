class TestResult:
    def __init__(self):
        self.runCount= 0
        self.errorCount= 0
    def testFailed(self):
        self.errorCount = self.errorCount + 1
    def testStarted(self):
        self.runCount = self.runCount + 1
    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.errorCount)


class TestCase:
    def __init__(self, name):
        self.name = name

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def run(self,result):
        result.testStarted()
        self.setUp()
        try:
            method = getattr(self, self.name)
            method()
        except:
            result.testFailed()
        self.tearDown()


class WasRun(TestCase):
    def __init__(self, name):
        self.wasRun = None
        TestCase.__init__(self, name)

    def testMethod(self):
        self.log = self.log + "testMethod "

    def testBrokenMethod(self):
        raise Exception

    def setUp(self):
        self.log = "setUp "

    def tearDown(self):
        self.log = self.log + "tearDown "

class TestSuite:
    def __init__(self):
        self.tests= []
    def add(self,test):
        self.tests.append(test)
    def run(self,result):
        for test in self.tests:
            test.run(result)


class TestCaseTest(TestCase):
    def setUp(self):
        self.result = TestResult()
    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run(self.result)
        assert ("setUp testMethod tearDown " == test.log)

    def testResult(self):
        test = WasRun("testMethod")
        result = test.run(self.result)
        assert ("1 run, 0 failed" == result.summary())

    def testFailedResult(self):
        test= WasRun("testBrokenMethod")
        result= test.run(self.result)
        assert ("1 run, 1 failed" == result.summary())

    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert ("1 run, 1 failed"==  self.result.summary())

    def testSuite(self):
        suite= TestSuite()
        suite.add(WasRun("testTemplateMethod"))
        suite.add(WasRun("testResult"))
        suite.add(WasRun("testFailedResultFormatting"))
        suite.add(WasRun("testFailedResult"))
        suite.add(WasRun("testSuite"))
        suite.run(self.result)
        assert("2 run, 1 failed" == self.result.summary())

result = TestResult()
print(TestCaseTest("testSuite").run(result))

# print(TestCaseTest("testTemplateMethod").run().summary())
# print(TestCaseTest("testResult").run().summary())
# print(TestCaseTest("testFailedResultFormatting").run().summary())
# print(TestCaseTest("testFailedResult").run().summary())
