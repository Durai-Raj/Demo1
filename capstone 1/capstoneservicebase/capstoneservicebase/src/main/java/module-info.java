 module capstoneservicebase{
     uses capstoneservice.CapstoneServiceInterface;
     opens capstoneservice;
     exports capstoneservice;
     provides capstoneservice.CapstoneServiceInterface with capstoneservice.CapstoneServiceImpl;

}