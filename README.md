# JSON_XForm
JSON Transformation Performance Testing using JOLT JSON XForm in TIBCO BusinessWorks

## Overview
This project evaluates the performance differences between doing JSON 2 JSON transformations using the OOTB activities in TIBCO BW versus using a custom Java transformation called Jolt (https://github.com/bazaarvoice/jolt)

There are 2 ways to run these tests. 

1. Locally you can configure the TestJSONXForm process to run. Do this by adjusting the Timer activity and the ReadFile activity. The ReadFile activity needs to be adjusted to load the sampleJSON-200.json file located in the SampleJSON folder. This will be specific to your development environment. The Timer activity needs to be set to Run Once. Finally configure a Run Configuration to run this Process as well as the JSON2XML_XML2JSON and Jolt_JSON2JSON processes. You will see times printed out for 10 runs of each operation.

2. If you would rather run Load Tests against the processes, start the JSON2XML_XML2JSON and Jolt_JSON2JSON processes along with the XForm process which exposes a Restful service with the following signature: POST http://localhost:8080/xform?mode=[xml|json]. Alter the mode value to test the different options. Pass in the contents of the sampleJSON-200.json file as the POST body.
