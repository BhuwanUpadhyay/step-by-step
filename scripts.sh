# Port-forward using json path
###################################
#!/bin/bash

set -e

proxyKibana() {

  POD=$(kubectl get pod -n logging -l app=kibana -o jsonpath='{.items[0].metadata.name}')

  kubectl port-forward $POD -n logging 5601:5601

}

proxyPostgres() {

  POD=$(kubectl get pod -n prod -l app.kubernetes.io/name=postgresql -o jsonpath='{.items[0].metadata.name}')

  kubectl port-forward $POD -n prod 5432:5432

}
#######################################
