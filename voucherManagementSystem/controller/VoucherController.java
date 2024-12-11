@RestController
@RequestMapping("/vouchers")

public class VoucherController {
    
    @PostMapping("/createVoucher")
    public ResponseEntity<Voucher> createVoucher(@RequestBody Voucher voucher){
        return ResponseEntity.ok(voucherService.createVoucher(voucher));
    }

    @GetMapping("/getVoucher/{voucher_id}")
    public ResponseEntity<Voucher> getVoucherByVoucherId()
}