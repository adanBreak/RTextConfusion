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
