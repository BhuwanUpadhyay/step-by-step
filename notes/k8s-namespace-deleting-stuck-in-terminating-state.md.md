# k8s namespace deleting stuck in terminating state

- Get terminating state namespaces

```bash
kubectl get namespaces | grep Terminating
```

- Select your namespace

```bash
NAMESPACE=<namespace>
```

- Remove `kubernetes` from the `finalizers` array

```bash
kubectl get namespace $NAMESPACE -o json \
        | jq 'del(.spec.finalizers[] | select(. == "kubernetes"))' \
        | awk 'BEGIN{RS="";getline<"-";print>ARGV[1]}' $NAMESPACE.tmp.json
```

- See the changes

```bash
cat $NAMESPACE.tmp.json
```

- Cleanup command

```bash
kubectl replace \
	--raw "/api/v1/namespaces/$NAMESPACE/finalize" \
	-f $NAMESPACE.tmp.json
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTM0MjUwNTQ0OV19
-->