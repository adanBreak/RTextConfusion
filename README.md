# RTextConfusion

Made by Gordon

The master is responsible for managing the cluster.
kubenetes.io/docs/tutorials/kubernetes-basics/create-cluster/cluster-intro
Minikube is a lightweight Kubernetes implementaion that create a VM on your local machine and deploys a simple cluster containing only one node.
Minikube CLI provides basic boostrapping operations for working with your clusters.

Kubernetes Objects
Kubernetes Objects ae persistent entiies in the Kubernetes system.
Object Specs and Status

Cloud Controller Manager
Allow cloud specfic vendor code and the Kubernetes core to evolve independent of one another.
Allow new cloud providers to intergrate with Kubernetes easiliy by using plugins.
Node Controller: Initializing a node, get node's network address and hostname, check response.
Route Controller: Configure routes in the cloud appropriately s that containers on different odes in the Kubernetes cluster can communicate with each other. GCE
Service Controller: Responsible for listening to service create, update, delete events.


Service
Kubernetes gives pods their own IP address and a single DNS name for a set of pods, and can load balance across them
Service is an abstraction which defines a logical set of pods and policy by which to access them.
Can be multi-port services through protocols
Can be used for service discovery

Publishing Service
Cluster IP - Expose the service on a cluster-internal IP. It can be only reachable within the cluster.
NodePort - Expose the service on each Node's IP. Reach the service outside of the cluster by requesting NodeIP:NodePort
LoadBalancer - Expose service externally using a cloud provider's load balancer.
ExternalName - Maps the service to the contents of the externalName field. Easiest and right away to access external services.
ExternalIP - Specify external IPs

KCM https://feisky.gitbooks.io/kubernetes/content/components/controller-manager.html

Service
Kubernetes gives pods their own IP address and a single DNS name for a set of pods, and can load balance across them
Service is an abstraction which defines a logical set of pods and policy by which to access them.
Can be multi-port services through protocols
Can be used for service discovery

Publishing Service
Cluster IP - Expose the service on a cluster-internal IP. It can be only reachable within the cluster.
NodePort - Expose the service on each Node's IP. Reach the service outside of the cluster by requesting NodeIP:NodePort
LoadBalancer - Expose service externally using a cloud provider's load balancer.
ExternalName - Maps the service to the contents of the externalName field. Easiest and right away to access external services.
ExternalIP - Specify external IPs

DNS
Every service defined in the cluster is assigned a DNS name. 
When a pod is created, its hostname is the Pods' metadata.name value.

Deployment
- Create a deployment to make replicaset rollout updated.
-Don't use naked pods if you can avoid it. Naked pods will not be rescheduled in the event of a node failure

Scheduler
- A scheduler watches newly created pods that have no nodes assigned. If no suitable nodes to run, a pod will be kept unscheduled
