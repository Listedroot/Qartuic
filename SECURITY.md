# Security Policy

## Supported Versions
Qartuic supports all Minecraft protocol versions from 1.8.9 to 1.21.5. Security issues will be addressed for all supported versions.

## Reporting a Vulnerability
If you discover a protocol, implementation, or logic vulnerability, please open a private issue or contact the maintainers directly. Do **not** disclose security issues publicly until a fix is released.

## Security Best Practices
- All packet handling code is validated for length and structure to prevent malformed packet exploits.
- Registries are immutable after initialization to prevent race conditions.
- All errors are logged and never silently swallowed.
- Resource and thread safety are enforced throughout the codebase.

## FAQ
**Q: Does Qartuic implement encryption?**
A: Encryption hooks are planned, but not yet implemented. See CONTRIBUTING.md if you want to help.

**Q: Are there known protocol exploits?**
A: Not at this time. If you discover one, please report it privately.

**Q: Is the library suitable for public-facing servers?**
A: Yes, provided you follow best practices and keep dependencies up to date.
